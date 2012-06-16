package com.zeharov.jaz.web;

import com.zeharov.jaz.domain.Image;
import com.zeharov.jaz.ejb.ImageEJB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class ImageBean implements Serializable {
    
    private ListDataModel<Image> images = new ListDataModel<Image>();
    private Image image;
    
    @Inject
    private ImageEJB imageEJB;
    
    public String addImage() {
        image = new Image(); 
        return "addImage";
    }
    
    public String editImage() {
        image = images.getRowData();
        return "editImage";
    }
    
    public String deleteImage() {
        imageEJB.delete(images.getRowData());
        return "allImages";
    }
    
    public String showImage() {
        image = images.getRowData();
        return "showImage";
    }
    
    public String persist() {
        imageEJB.persist(image);
        return "allImages";
    }

    public ListDataModel<Image> getIamges() {
        images.setWrappedData(imageEJB.getImages());
        return images;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
