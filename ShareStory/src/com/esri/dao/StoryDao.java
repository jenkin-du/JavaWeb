package com.esri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.esri.bean.Point;
import com.esri.bean.SharedStory;
import com.esridb.DBLinker;



public class StoryDao {

	/**
	 * 保存story
	 * 
	 * @param story
	 */
	public static void saveStory(SharedStory story) {

		Connection conn = DBLinker.getConnection();

		String sql = "insert into shared_story(story_id,time,message,image_name,longitude,latitude)values(?,?,?,?,?,?)";

		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, story.getId());
			state.setString(2, story.getTime());
			state.setString(3, story.getMessage());
			state.setString(4, story.getImageName());
			state.setString(5, story.getLongitude());
			state.setString(6, story.getLatitude());
			state.execute();

			sql = "insert into image(image_name,image_code)values(?,?)";
			state = conn.prepareStatement(sql);

			state.setString(1, story.getImageName());
			state.setString(2, story.getImageCode());
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<SharedStory> getStory(Point center, double radius) {

		// TODO根据中心点和半径进行查找

		ArrayList<SharedStory> stories=new ArrayList<>();
		SharedStory story;
		
		Connection conn = DBLinker.getConnection();

		String sql = "select * from image as i,shared_story as s where i.image_name=s.image_name ";
		
		try {
			Statement state=	conn.createStatement();
			ResultSet rs= state.executeQuery(sql);
			while(rs.next()){
				story=new SharedStory();
				story.setId(rs.getString("story_id"));
				story.setTime(rs.getString("time"));
				story.setMessage(rs.getString("message"));
				story.setImageName(rs.getString("i.image_name"));
				story.setImageCode(rs.getString("image_code"));
				story.setLongitude(rs.getString("longitude"));
				story.setLatitude(rs.getString("latitude"));
				
				stories.add(story);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stories;

	}
}
