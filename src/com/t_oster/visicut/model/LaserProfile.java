/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t_oster.visicut.model;

import com.t_oster.liblasercut.LaserJob;
import com.t_oster.liblasercut.LaserProperty;
import com.t_oster.visicut.gui.ImageListable;
import com.t_oster.visicut.model.graphicelements.GraphicSet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * A cutting Profile represents a specific way of handling Image
 * Parts. This means a CuttingProfile provides methods
 * to generate preview and laser data out of Graphic parts.
 * @author thommy
 */
public abstract class LaserProfile implements ImageListable, Cloneable
{

  protected String description = "A new Laserprofile";

  /**
   * Get the value of description
   *
   * @return the value of description
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Set the value of description
   *
   * @param description new value of description
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  protected List<LaserProperty> laserProperties = new LinkedList<LaserProperty>();
  public static final String PROP_LASERPROPERTIES = "laserProperties";

  /**
   * Get the value of laserProperties
   *
   * @return the value of laserProperties
   */
  public List<LaserProperty> getLaserProperties()
  {
    return laserProperties;
  }

  /**
   * Set the value of laserProperties
   *
   * @param laserProperties new value of laserProperties
   */
  public void setLaserProperties(List<LaserProperty> laserProperties)
  {
    List<LaserProperty> oldLaserProperties = this.laserProperties;
    this.laserProperties = laserProperties;
    propertyChangeSupport.firePropertyChange(PROP_LASERPROPERTIES, oldLaserProperties, laserProperties);
  }
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  /**
   * Add PropertyChangeListener.
   *
   * @param listener
   */
  public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  /**
   * Remove PropertyChangeListener.
   *
   * @param listener
   */
  public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }


  protected Color color = new Color(0, 0, 0);

  /**
   * Get the value of color
   *
   * @return the value of color
   */
  public Color getColor()
  {
    return color;
  }

  /**
   * Set the value of color
   *
   * @param color new value of color
   */
  public void setColor(Color color)
  {
    this.color = color;
  }
  
  protected String thumbnailPath = "/home/thommy/NetBeansProjects/jepilog/materials/Fliess/bigcut.png";

  /**
   * Get the value of thumbnailPath
   *
   * @return the value of thumbnailPath
   */
  public String getThumbnailPath()
  {
    return thumbnailPath;
  }

  /**
   * Set the value of thumbnailPath
   *
   * @param thumbnailPath new value of thumbnailPath
   */
  public void setThumbnailPath(String thumbnailPath)
  {
    this.thumbnailPath = thumbnailPath;
  }

  /**
   * Get the value of previewThumbnail
   *
   * @return the value of previewThumbnail
   */
  public File getPreviewThumbnail()
  {
    return new File(this.thumbnailPath);
  }

  /**
   * Set the value of previewThumbnail
   *
   * @param previewThumbnail new value of previewThumbnail
   */
  public void setPreviewThumbnail(File previewThumbnail)
  {
    this.thumbnailPath = previewThumbnail.getPath();
  }
  protected String name = "Unnamed Profile";

  /**
   * Get the value of name
   *
   * @return the value of name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Set the value of name
   *
   * @param name new value of name
   */
  public void setName(String name)
  {
    this.name = name;
  }

  public abstract void renderPreview(Graphics2D g, GraphicSet objects);

  public abstract void addToLaserJob(LaserJob job, GraphicSet objects);

  public void addToLaserJob(LaserJob job, GraphicSet set, float focusOffset)
  {
    for (LaserProperty p:this.getLaserProperties())
    {
      p.setFocus(p.getFocus()+focusOffset);
    }
    this.addToLaserJob(job, set);
    for (LaserProperty p:this.getLaserProperties())
    {
      p.setFocus(p.getFocus()-focusOffset);
    }
  }

  @Override
  public String toString()
  {
    return (this.getName() != null ? this.getName() : super.toString());
  }

  @Override
  public abstract LaserProfile clone();
}