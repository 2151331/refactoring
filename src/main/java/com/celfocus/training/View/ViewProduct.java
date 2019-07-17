package com.celfocus.training.View;

import com.celfocus.training.business.exception.DeleteException;
import com.celfocus.training.business.exception.FindException;
import com.celfocus.training.business.exception.SaveException;
import com.celfocus.training.business.logger.ConsoleLogger;
import com.celfocus.training.controller.IProductController;
import com.celfocus.training.controller.dtos.ProductDTO;

import java.util.List;

public class ViewProduct {

    private ConsoleLogger consoleLogger;
    public static final String SPAN = "<span>";
    IProductController productController;

    public ViewProduct(IProductController productController) {
        this.productController = productController;
        this.consoleLogger = new ConsoleLogger();
    }

    public void saveProduct(ProductDTO productDTO) {
        try {

            this.productController.createProduct(productDTO);

        } catch (SaveException e) {
            e.printStackTrace();
        }
    }

    public void printProducts(){
        List<ProductDTO> allProductDTO = productController.getAllProductDTO();

        this.consoleLogger.writeInfo("All Products");

        for (ProductDTO productDTO : allProductDTO) {
            this.consoleLogger.writeInfo(productDTO.toString());
        }

       this.consoleLogger.writeInfo("----------");
    }

    public String showUser(TypeFile typeFile, ProductDTO productDTO) {
        return "";
    }

    private String buildFileProductXml(ProductDTO productDTO) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>")
                .append("<productName>").append(productDTO.getProductName()).append("<productName>")
                .append("<amount>").append(productDTO.getAmount()).append("<amount>");


        return stringBuilder.toString();
    }

    private String buildFileProductHtml(ProductDTO productDTO) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("<div>")
                .append("<h1>Product</h1>")
                .append(SPAN).append(productDTO.getProductName()).append(SPAN)
                .append(SPAN).append(productDTO.getAmount()).append(SPAN)
                .append("</div>");

        return stringBuilder.toString();
    }

    public void updateUser(ProductDTO productDTO) {
        try {
            productController.updateProduct(productDTO);
        } catch (SaveException e) {
            e.printStackTrace();
        } catch (FindException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(ProductDTO productDTO) {
        try {
            productController.deleteProduct(productDTO);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
    }

}
