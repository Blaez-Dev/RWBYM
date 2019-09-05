package be.bluexin.rwbym.capabilities.team;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface ITeam {
	
	public EntityPlayer[] getTeam(EntityPlayer player);
	
	public boolean hasRoom(EntityPlayer player);
	
	public boolean isSolo(EntityPlayer player);
	
	public List<Request> getSentRequests(EntityPlayer player);
	
	public List<Request> getReceivedRequests(EntityPlayer player);
	
	public Request getRequest(EntityPlayer sender, EntityPlayer receiver);
	
	public void sendRequest(String sender, String receiver);
	
	public void sendRequest(EntityPlayer sender, EntityPlayer receiver);
	
	public void confirmRequest(String sender, String receiver);
	
	public void confirmRequest(EntityPlayer sender, EntityPlayer receiver);
	
	public void denyRequest(String sender, String receiver);
	
	public void denyRequest(EntityPlayer sender, EntityPlayer receiver);
	
	public void leaveTeam(String player);

	public void leaveTeam(EntityPlayer player);
			
	public void setWorld(World world);

	public NBTTagCompound serialize();
	
	public void deserialize(NBTTagCompound nbt);
	
	public void markDirty();
	
	public boolean isDirty();
	
	public static class Request {
		
		private EntityPlayer sender;
		private EntityPlayer receiver;
		
		protected Request (EntityPlayer sender, EntityPlayer receiver) {
			this.sender = sender;
			this.receiver = receiver;
		}
		
		public EntityPlayer getSender() {
			return sender;
		}
		
		public EntityPlayer getReceiver() {
			return receiver;
		}
		
	}
	
}
