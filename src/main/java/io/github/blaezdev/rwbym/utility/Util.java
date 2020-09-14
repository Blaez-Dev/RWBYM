package io.github.blaezdev.rwbym.utility;

import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class Util {
	public static NBTTagCompound getOrCreateTag(ItemStack stack) {
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {
			nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
		}
		return nbt;
	}
	
	public static int sign(double x) {
		return (int) (Math.abs(x)/x);
	}
	
	public static double invLerp(double a, double b, double c) {
		return (c - a) / (b - a);
	}
	
	public static double lerp(double a, double b, double k) {
		return (1 - k)*a + k*b;
	}
	
	public static RayTraceResult rayTraceEntity(Vec3d vec3d1, Vec3d vec3d2, Entity entity) {
		
		double x1 = vec3d1.x;
		double x2 = vec3d2.x;
		double y1 = vec3d1.y;
		double y2 = vec3d2.y;
		double z1 = vec3d1.z;
		double z2 = vec3d2.z;
		
		double x;
		double y;
		double z;
		
		double k = 0;
		
		AxisAlignedBB entityAABB = entity.getEntityBoundingBox();
		
		if (entityAABB == null) {
			RWBYModels.LOGGER.error("AABB is NULL");
			return null;
		}
		
		double dx = x2 - x1;
		double dy = y2 - y1;
		double dz = z2 - z1;
		
		if (dx >= 0) {
			k = invLerp(x1, x2, entityAABB.minX);
			x = entityAABB.minX;
			y = lerp(y1, y2, k);
			z = lerp(z1, z2, k);
			if (y >= entityAABB.maxY) {
				if (dy > 0) {
					//LOGGER.error("Ray Not in EntityAABB");
					return null;
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z >= entityAABB.maxZ) {
						k = invLerp(z1, z2, entityAABB.maxZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.maxZ;
						if (x > entityAABB.maxX || y < entityAABB.minY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						//LOGGER.info("Created Ray Trace Result");
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z < entityAABB.minZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					//LOGGER.info("Created Ray Trace Result");
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ) {
						k = invLerp(z1, z2, entityAABB.minZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.minZ;
						if (x > entityAABB.maxX || y < entityAABB.minY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.minZ && z < entityAABB.maxZ) {
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ || z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
			}
			if (y < entityAABB.minY) {
				if (dy < 0) {
					//LOGGER.error("Ray Not in EntityAABB");
					return null;
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z >= entityAABB.maxZ) {
						k = invLerp(z1, z2, entityAABB.maxZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.maxZ;
						if (x > entityAABB.maxX || y > entityAABB.maxY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z < entityAABB.minZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ) {
						k = invLerp(z1, z2, entityAABB.minZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.minZ;
						if (x > entityAABB.maxX || y > entityAABB.maxY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.minZ && z < entityAABB.maxZ) {
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ || z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
			}
			if (y >= entityAABB.minY && y < entityAABB.maxY) {
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(z1, z2, entityAABB.minZ);
					x = lerp(x1, x2, k);
					y = lerp(y1, y2, k);
					z = entityAABB.minZ;
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (y < entityAABB.minY || y > entityAABB.maxY) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(z1, z2, entityAABB.maxZ);
					x = lerp(x1, x2, k);
					y = lerp(y1, y2, k);
					z = entityAABB.maxZ;
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (y < entityAABB.minY || y > entityAABB.maxY) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				return new RayTraceResult(entity, new Vec3d(x, y, z));
			}
		}
		if (dx < 0) {
			k = invLerp(x1, x2, entityAABB.maxX);
			x = entityAABB.maxX;
			y = lerp(y1, y2, k);
			z = lerp(z1, z2, k);
			if (y >= entityAABB.maxY) {
				if (dy > 0) {
					//LOGGER.error("Ray Not in EntityAABB");
					return null;
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z >= entityAABB.maxZ) {
						k = invLerp(z1, z2, entityAABB.maxZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.maxZ;
						if (x < entityAABB.minX || y < entityAABB.minY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z < entityAABB.minZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ) {
						k = invLerp(z1, z2, entityAABB.minZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.minZ;
						if (x < entityAABB.minX || y < entityAABB.minY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.minZ && z < entityAABB.maxZ) {
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ || z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
			}
			if (y < entityAABB.minY) {
				if (dy < 0) {
					//LOGGER.error("Ray Not in EntityAABB");
					return null;
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z >= entityAABB.maxZ) {
						k = invLerp(z1, z2, entityAABB.maxZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.maxZ;
						if (x < entityAABB.minX || y > entityAABB.maxY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z < entityAABB.minZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ) {
						k = invLerp(z1, z2, entityAABB.minZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.minZ;
						if (x < entityAABB.minX || y > entityAABB.maxY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.minZ && z < entityAABB.maxZ) {
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ || z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
			}
			if (y >= entityAABB.minY && y < entityAABB.maxY) {
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(z1, z2, entityAABB.minZ);
					x = lerp(x1, x2, k);
					y = lerp(y1, y2, k);
					z = entityAABB.minZ;
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (y < entityAABB.minY || y > entityAABB.maxY) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(z1, z2, entityAABB.maxZ);
					x = lerp(x1, x2, k);
					y = lerp(y1, y2, k);
					z = entityAABB.maxZ;
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (y < entityAABB.minY || y > entityAABB.maxY) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				return new RayTraceResult(entity, new Vec3d(x, y, z));
			}
		}
		RWBYModels.LOGGER.error("Ray Not in EntityAABB catch");
		return null;
	}
}
