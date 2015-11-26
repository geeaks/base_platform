package com.gts.base.platform.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class IdentifyingCode {
	
	/**
	 * @Fields width : 验证码图片的宽度
	 */ 
	private int width = 133;
	
	/**
	 * @Fields height : 验证码图片的高度
	 */ 
	private int height = 34;
	
	/**
	 * @Fields random : 验证码的数量
	 */ 
	private Random random = new Random();
	
	/**
	 * @Description: 生成随机颜色
	 * @param fc 前景色
	 * @param bc 背景色
	 * @return Color Color对象，此Color对象是RGB形式的。
	 * @author gaoxiang
	 * @date 2015年11月27日 上午1:24:53
	 */
	public Color getRandomColor(int fc, int bc) {
		if (fc > 255)
			fc = 200;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	/**
	 * @Description: 绘制干扰线
	 * @param g Graphics2D对象，用来绘制图像
	 * @param nums 干扰线的条数
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月27日 上午1:25:22
	 */
	public void drawRandomLines(Graphics2D g, int nums) {
		g.setColor(this.getRandomColor(200, 300));
		for (int i = 0; i < nums; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(14);
			int y2 = random.nextInt(14);
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	/**
	 * @Description: 获取随机字符串， 此函数可以产生由大小写字母，汉字，数字组成的字符串
	 * @param length 随机字符串的长度
	 * @param g
	 * @return String 随机字符串
	 * @author gaoxiang
	 * @date 2015年11月27日 上午1:25:40
	 */
	public String drawRandomString(int length, Graphics2D g) {
		StringBuffer strbuf = new StringBuffer();
		String temp = "";
		int itmp = 0;
		for (int i = 0; i < length; i++) {
			switch (random.nextInt(5)) {
			case 1: // 生成A～Z的字母
				itmp = random.nextInt(26) + 65;
				if (itmp != 79) {
					temp = String.valueOf((char) itmp);
				} else {
					temp = String.valueOf((char) (itmp + 1));
				}
				break;
			case 2:
				itmp = random.nextInt(26) + 97;
				if (itmp != 111) {
					temp = String.valueOf((char) itmp);
				} else {
					temp = String.valueOf((char) (itmp + 1));
				}
				break;
			default:
				itmp = random.nextInt(10) + 48;
				if (itmp != 48) {
					temp = String.valueOf((char) itmp);
				} else {
					temp = String.valueOf((char) (itmp + 1));
				}
				break;
			}
			Color color = new Color(20 + random.nextInt(20), 20 + random.nextInt(20), 20 + random.nextInt(20));
			g.setColor(color);
			// 想文字旋转一定的角度
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(20) * 3.14 / 180, 12 * i + 5, 3);
			// 缩放文字
			float scaleSize = random.nextFloat() + 1.2f;
			if (scaleSize > 1f)
				scaleSize = 1.2f;
			trans.scale(scaleSize, scaleSize);
			g.setTransform(trans);
			g.drawString(temp, 15 * i + 18, 14);
			
			strbuf.append(temp);
		}
		g.dispose();
		return strbuf.toString();
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
}
