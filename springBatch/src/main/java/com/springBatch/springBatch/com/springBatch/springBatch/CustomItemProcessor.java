package com.springBatch.springBatch.com.springBatch.springBatch;


import com.springBatch.springBatch.com.springBatch.model.Products;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Products, Products> {
    @Override
    public Products process(Products item) throws Exception {

		try {
        } catch (
                NumberFormatException ex
        ) {
            ex.printStackTrace();
        }

        return item;
    }
}
