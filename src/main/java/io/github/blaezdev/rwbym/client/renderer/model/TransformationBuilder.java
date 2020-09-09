package io.github.blaezdev.rwbym.client.renderer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;

import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraftforge.common.model.TRSRTransformation;

public class TransformationBuilder {
	
	Map<Integer, Vector3f> scales = new TreeMap<>();
	Map<Integer, Vector3f> rotations = new TreeMap<>();
	Map<Integer, Vector3f> centers = new TreeMap<>();
	Map<Integer, Vector3f> translations = new TreeMap<>();

	private Vector3f scale = new Vector3f(1, 1, 1);
	private Vector3f rotation = new Vector3f();
	private Vector3f center = new Vector3f();
	private Vector3f translation = new Vector3f();
			
	public TransformationBuilder add(Vector3f translation, Vector3f rotation, Vector3f center, Vector3f scale, int order) {
		
		if (scale == null) {
			scale = new Vector3f(1, 1, 1);
		}
		if (rotation == null) {
			rotation = new Vector3f();
		}
		if (center == null) {
			center = new Vector3f();
		}
		if (translation == null) {
			translation = new Vector3f();
		}
		Vector3f replaced = scales.put(order, new Vector3f(scale));
		rotations.put(order, new Vector3f(rotation));
		centers.put(order, new Vector3f(center));
		translations.put(order, new Vector3f(translation));
		
		if (replaced != null && order != 0) {
			RWBYModels.LOGGER.warn("Transorm was replaced");
		}
		return this;
	}

	public TRSRTransformation build() {
		
		return TRSRTransformation.blockCenterToCorner(new TRSRTransformation(this.buildMatirx()));
		
	}
	
	public Matrix4f buildMatirx() {
		
		List<Matrix4f> matrixList = new ArrayList<>();
		
		for (int i : scales.keySet()) {
			Vector3f scale = scales.get(i);
			Vector3f rotation = rotations.get(i);
			Vector3f center = centers.get(i);
			Vector3f translation = translations.get(i);
			
			Matrix4f ST = matrixFromScaleAndTranslation(scale, translation);
			Matrix4f C1 = matrixFromScaleAndTranslation(new Vector3f(1, 1, 1), center);
			center.scale(-1);
			Matrix4f C2 = matrixFromScaleAndTranslation(new Vector3f(1, 1, 1), center);
			Matrix4f R = matrixFromRotationDegrees(rotation);
			
			Matrix4f Final = new Matrix4f();
			Final.setIdentity();
			
			Final.mul(ST, Final);
			Final.mul(C2, Final);
			Final.mul(R, Final);
			Final.mul(C1, Final);
			
			matrixList.add(Final);
		}
		
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
				
		for (Matrix4f t : matrixList) {
			matrix.mul(t, matrix);
		}
		
		return matrix;
	}
	
	private Matrix4f matrixFromScaleAndTranslation(Vector3f scale, Vector3f translation) {
		
		Matrix4f t = new Matrix4f();
		
		t.m00 = scale.x;
		t.m10 = 0;
		t.m20 = 0;
		t.m30 = 0;
		
		t.m01 = 0;
		t.m11 = scale.y;
		t.m21 = 0;
		t.m31 = 0;
		
		t.m02 = 0;
		t.m12 = 0;
		t.m22 = scale.z;
		t.m32 = 0;
		
		t.m03 = translation.x;
		t.m13 = translation.y;
		t.m23 = translation.z;
		t.m33 = 1;
		
		return t;
	}

	private Matrix4f matrixFromRotationDegrees(Vector3f rotation) {
		
		rotation.scale((float) (Math.PI / 180));
		
		Matrix4f tx = new Matrix4f(), ty = new Matrix4f(), tz = new Matrix4f();
		tx.setIdentity();
		ty.setIdentity();
		tz.setIdentity();
		
		tx.m11 = (float) Math.cos(rotation.x);
		tx.m21 = (float) Math.sin(rotation.x);
		
		tx.m12 = (float) -Math.sin(rotation.x);
		tx.m22 = (float) Math.cos(rotation.x);
		
		
		ty.m00 = (float) Math.cos(rotation.y);
		ty.m20 = (float) Math.sin(rotation.y);
		
		ty.m02 = (float) -Math.sin(rotation.y);
		ty.m22 = (float) Math.cos(rotation.y);
		
		
		tz.m00 = (float) Math.cos(rotation.z);
		tz.m10 = (float) -Math.sin(rotation.z);
		
		tz.m01 = (float) Math.sin(rotation.z);
		tz.m11 = (float) Math.cos(rotation.z);
		
		Matrix4f M = new Matrix4f();
		M.setIdentity();
		
		M.mul(tx, M);
		M.mul(ty, M);
		M.mul(tz, M);
				
		return M;
	}
}
