package be.bluexin.rwbym.utility;

public class RWBYMath {
	public static double cosd(double x) {
		return Math.cos(x * Math.PI / 180D);
	}
	
	public static double sind(double x) {
		return Math.sin(x * Math.PI / 180D);
	}
	
	public static double atan2d(double y, double x) {
		return Math.atan2(y, x) * 180 / Math.PI;
	}
}
