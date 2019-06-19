package com.lti.training.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;
import javax.servlet.*;
/**
 * Servlet implementation class CaptchaServlets
 */
@WebServlet("/captcha.jpg")
public class CaptchaServlets extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		
		String src="abcdefghijkmnopqsrtcABCDEFGHIJKLMNOPQRSTUVWXYZ)123456789";
		String captcha = "";
		
		
		for(int i=0;i<=5;i++)
			{
			int index 
            = (int)(src.length() 
                    * Math.random());
			captcha +=src.charAt(index);
			}
		
		//now the code to generate the image 
		BufferedImage img = new BufferedImage(150,50,BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.red);
		g.fillRect(0, 0, 150, 50);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Harrington", Font.BOLD, 32));
		g.drawString(captcha, 30, 30);

		ImageIO.write(img, "jpeg", out);
}
}
