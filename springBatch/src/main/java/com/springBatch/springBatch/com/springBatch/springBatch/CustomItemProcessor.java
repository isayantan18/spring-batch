package com.springBatch.springBatch.com.springBatch.springBatch;


import com.springBatch.springBatch.com.springBatch.model.Products;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Products, Products> {
    @Override
    public Products process(Products item) throws Exception {

		try {/*
				 * 
				 * // put the percentage logic System.out.println(item.getDescription()); int
				 * int discountPer = Integer.parseInt(item.getDiscount().trim()); double
				 * originalPrice = Double.parseDouble(item.getPrice().trim()); double discount =
				 * (discountPer / 100) * originalPrice; double finalPrice = originalPrice -
				 * discount;
				 */
				 
            //item.setDiscountedPrice(String.valueOf(finalPrice));
        } catch (
                NumberFormatException ex
        ) {
            ex.printStackTrace();
        }

        return item;
    }
}