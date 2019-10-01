package io.github.blaez-dev.rwbym.capabilities.team;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.utility.network.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team implements ITeam {
	
	private List<List<EntityPlayer>> teams = new ArrayList<>();
	
	private List<Request> requests = new ArrayList<>();
	
	private World world;
	
	private boolean dirty = false;
	
	@Override
	public EntityPlayer[] getTeam(EntityPlayer player) {
		
		for (List<EntityPlayer> team : teams) {
			List<EntityPlayer> teamCopy = new ArrayList<>(team);
			if (teamCopy.removeIf(member -> member.equals(player))) {
				return teamCopy.toArray(new EntityPlayer[3]);
			}
		}
		
		return new EntityPlayer[3];
	}
	
	@Override
	public boolean hasRoom(EntityPlayer player) {
		
		for (List<EntityPlayer> team : teams) {
			if (team.contains(player)) {
				return team.size() < 4;
			}
		}
		
		return true;
		
	}
	
	@Override
	public boolean isSolo(EntityPlayer player) {
		return this.getTeamList(player).size() == 1;
	}
	
	@Override
	public List<Request> getSentRequests(EntityPlayer player) {
		
		List<Request> sent = new ArrayList<>();
		
		for (Request request : requests) {
			if (request.getSender().equals(player)) {
				sent.add(request);
			}
		}
		
		return sent;
		
	}
	
	@Override
	public List<Request> getReceivedRequests(EntityPlayer player) {
		
		List<Request> received = new ArrayList<>();
		
		for (Request request : requests) {
			if (request.getReceiver().equals(player)) {
				received.add(request);
			}
		}
		
		return received;
		
	}
	
	@Override
	public Request getRequest(EntityPlayer sender, EntityPlayer receiver) {
		
		for (Request request : requests) {
			
			if (request.getSender().equals(sender) && request.getReceiver().equals(receiver)) {
				return request;
			}
			
		}
		
		return null;
	}
	
	@Override
	public void sendRequest(String sender, String receiver) {
		this.sendRequest(world.getPlayerEntityByUUID(UUID.fromString(sender)), world.getPlayerEntityByUUID(UUID.fromString(receiver)));
	}
	
	@Override
	public void sendRequest(EntityPlayer sender, EntityPlayer receiver) {
		if (sender == null || receiver == null) {
			return ;
		}
		if (this.world.isRemote) {
			RWBYNetworkHandler.sendToServer(new MessageSendRequest(sender, receiver));
		}
		else {
			this.markDirty();
		}
		if (this.hasRoom(sender) && this.isSolo(receiver)) {
			this.requests.add(new Request(sender, receiver));
		}
	}
	
	@Override
	public void confirmRequest(String sender, String receiver) {
		this.confirmRequest(world.getPlayerEntityByUUID(UUID.fromString(sender)), world.getPlayerEntityByUUID(UUID.fromString(receiver)));
	}
	
	@Override
	public void confirmRequest(EntityPlayer sender, EntityPlayer receiver) {
		if (sender == null || receiver == null) {
			return ;
		}
		if (this.world.isRemote) {
			RWBYNetworkHandler.sendToServer(new MessageConfirmRequest(sender, receiver));
		}
		else {
			this.markDirty();
		}
		Request request = this.getRequest(sender, receiver);
		if (request != null && this.hasRoom(sender) && this.isSolo(receiver)) {
			List<EntityPlayer> team = this.getTeamList(sender);
			team.add(receiver);
			if (this.isSolo(sender)) {
				teams.add(team);
			}
			requests.remove(request);
		}
	}
	
	@Override
	public void denyRequest(String sender, String receiver) {
		this.denyRequest(world.getPlayerEntityByUUID(UUID.fromString(sender)), world.getPlayerEntityByUUID(UUID.fromString(receiver)));
	}
	
	@Override
	public void denyRequest(EntityPlayer sender, EntityPlayer receiver) {
		if (sender == null || receiver == null) {
			return ;
		}
		if (this.world.isRemote) {
			RWBYNetworkHandler.sendToServer(new MessageDenyRequest(sender, receiver));
		}
		else {
			this.markDirty();
		}
		Request request = this.getRequest(sender, receiver);
		if (request != null) {
			requests.remove(request);
		}
	}
	
	@Override
	public void leaveTeam(String player) {
		this.leaveTeam(world.getPlayerEntityByUUID(UUID.fromString(player)));
	}
	
	@Override
	public void leaveTeam(EntityPlayer player) {
		if (player == null) {
			return;
		}
		if (this.world.isRemote) {
			RWBYNetworkHandler.sendToServer(new MessageLeaveTeam(player));
		}
		else {
			this.markDirty();
		}
		this.getTeamList(player).remove(player);
		if (this.isSolo(player)) {
			List<EntityPlayer> team = this.getTeamList(player);
			this.teams.remove(team);
		}
	}
	
	@Override
	public void setWorld(World world) {
		this.world = world;
	}

	@Override
	public NBTTagCompound serialize() {
		
		requests.removeIf(request -> (request.getSender() == null || request.getReceiver() == null));
		teams.removeIf(team -> team.size() < 2);
		
		NBTTagCompound nbt = new NBTTagCompound();
		NBTTagCompound teamsnbt = new NBTTagCompound();
		NBTTagCompound requestsnbt = new NBTTagCompound();
		
		Integer i = 0;
		for (List<EntityPlayer> team : teams) {
			NBTTagCompound teamnbt = new NBTTagCompound();
			Integer j = 0;
			for (EntityPlayer player : team) {
				if (player != null) {
					teamnbt.setString(j.toString(), player.getCachedUniqueIdString());
					if (player instanceof EntityPlayerMP && ((EntityPlayerMP)player).hasDisconnected()) {
						teamnbt.setTag(j.toString() + "data", player.writeToNBT(new NBTTagCompound()));
						teamnbt.setInteger(j.toString() + "id", player.getEntityId());
						teamnbt.setString(j.toString() + "name", player.getName());
					}
					j++;
				}
			}
			teamnbt.setInteger("size", j);
			teamsnbt.setTag(i.toString(), teamnbt);
			i++;
		}
		
		i = 0;
		for (Request request : requests) {
			requestsnbt.setString(i.toString() + "sender", request.getSender().getCachedUniqueIdString());
			requestsnbt.setString(i.toString() + "receiver", request.getReceiver().getCachedUniqueIdString());
			i++;
		}
		
		nbt.setTag("teams", teamsnbt);
		nbt.setTag("requests", requestsnbt);
		nbt.setInteger("requestSize", i);
		
		return nbt;
		
	}

	@Override
	public void deserialize(NBTTagCompound nbt) {
		
		teams.clear();
		requests.clear();
		
		NBTTagCompound teamsnbt = nbt.getCompoundTag("teams");
		NBTTagCompound requestsnbt = nbt.getCompoundTag("requests");
		
		for (String key : teamsnbt.getKeySet()) {
			
			NBTTagCompound teamnbt = teamsnbt.getCompoundTag(key);
			List<EntityPlayer> team = new ArrayList<>();
			int i2 = teamnbt.getInteger("size");
			for (Integer i = 0; i < i2; i++) {
				EntityPlayer member = this.world.getPlayerEntityByUUID(UUID.fromString(teamnbt.getString(i.toString())));
				if (member == null) {
					member = RWBYModels.proxy.loadPlayer(teamnbt, i.toString(), world);
				}
				team.add(member);
			}
			
			teams.add(team);
			
		}
		
		int i1 = nbt.getInteger("requestSize");
		
		for (Integer i = 0; i < i1; i++) {
			
			EntityPlayer sender = world.getPlayerEntityByUUID(UUID.fromString(requestsnbt.getString(i.toString() + "sender")));
			EntityPlayer receiver = world.getPlayerEntityByUUID(UUID.fromString(requestsnbt.getString(i.toString() + "receiver")));
			
			requests.add(new Request(sender, receiver));
			
		}
		
	}
	
	@Override
	public void markDirty() {
		this.dirty = true;
	}
	
	@Override
	public boolean isDirty() {
		boolean flag = this.dirty;
		this.dirty = false;
		return flag;
	}
	
	private List<EntityPlayer> getTeamList(EntityPlayer player) {
		
		for (List<EntityPlayer> team : teams) {
			if (team.contains(player)) {
				return team;
			}
		}
		
		List<EntityPlayer> team = new ArrayList<>(4);
		team.add(player);
		
		return team;
		
	}

}
