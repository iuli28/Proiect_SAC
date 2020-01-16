package com.demo.restaurants.demo.utils;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.springframework.stereotype.Component;

@Component
public class ManhattenDistanceSimilarityExample {

	public void runPrediciton() {
	try {
		DataModel model = new FileDataModel(new File("C:\\\\Users\\\\Iulian\\\\eclipse-workspace\\\\SAC\\\\Proiect_SAC\\\\demo\\\\src\\\\main\\\\resources\\\\static\\\\test.csv"));
		System.out.println(model.getNumItems());
		CityBlockSimilarity similarity = new CityBlockSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1,similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		  
			System.out.println("ruleaza");
     		// The First argument is the userID and the Second parameter is 'HOW MANY'
      		List<RecommendedItem> recommendations = recommender.recommend(Long.valueOf("1"), 2);      
			
     		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
     		
     		System.out.println("cscs");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}