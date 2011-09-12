package com.t_oster.visicut.model;

import com.t_oster.liblasercut.LaserJob;
import com.t_oster.liblasercut.LaserProperty;
import com.t_oster.liblasercut.platform.Point;
import com.t_oster.liblasercut.utils.BufferedImageAdapter;
import com.t_oster.visicut.misc.Helper;
import com.t_oster.visicut.model.graphicelements.GraphicObject;
import com.t_oster.visicut.model.graphicelements.GraphicSet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * This Class represents a profile, describing
 * how the Lasercutter generates RasterData
 * from given GraphicElements
 * 
 * @author thommy
 */
public class Raster3dProfile extends LaserProfile
{

  public Raster3dProfile()
  {
    this.setName("raster3d");
  }
  protected boolean invertColors = false;

  /**
   * Get the value of invertColors
   *
   * @return the value of invertColors
   */
  public boolean isInvertColors()
  {
    return invertColors;
  }

  /**
   * Set the value of invertColors
   *
   * @param invertColors new value of invertColors
   */
  public void setInvertColors(boolean invertColors)
  {
    this.invertColors = invertColors;
  }
  protected int colorShift = 0;

  /**
   * Get the value of colorShift
   *
   * @return the value of colorShift
   */
  public int getColorShift()
  {
    return colorShift;
  }

  /**
   * Set the value of colorShift
   *
   * @param colorShift new value of colorShift
   */
  public void setColorShift(int colorShift)
  {
    this.colorShift = colorShift;
  }

  @Override
  public void renderPreview(Graphics2D gg, GraphicSet objects)
  {
    Rectangle2D bb = objects.getBoundingBox();
    if (bb != null && bb.getWidth() > 0 && bb.getHeight() > 0)
    {
      BufferedImage scaledImg = new BufferedImage((int) bb.getWidth(), (int) bb.getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D g = scaledImg.createGraphics();
      g.setColor(Color.white);
      g.fillRect(0, 0, scaledImg.getWidth(), scaledImg.getHeight());
      if (objects.getTransform() != null)
      {
        Rectangle2D origBB = objects.getOriginalBoundingBox();
        Rectangle2D targetBB = new Rectangle(0, 0, scaledImg.getWidth(), scaledImg.getHeight());
        g.setTransform(Helper.getTransform(origBB, targetBB));
      }
      g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
      g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      for (GraphicObject o : objects)
      {
        o.render(g);
      }
      BufferedImageAdapter ad = new BufferedImageAdapter(scaledImg, invertColors);
      ad.setColorShift(this.getColorShift());
      for (int y = 0; y < ad.getHeight(); y++)
      {
        for (int x = 0; x < ad.getWidth(); x++)
        {
          if (ad.getGreyScale(x, y)<255)
          {//TODO: Scale color between profile color and material color
              double f = 1-(ad.getGreyScale(x, y)/255);
            Color scaled = new Color(
                    (int)(f*this.getColor().getRed()),
                    (int)(f*this.getColor().getGreen()),
                    (int)(f*this.getColor().getBlue())
                    );
            gg.setColor(scaled);
            gg.drawLine((int) bb.getX() + x, (int) bb.getY() + y, (int) bb.getX() + x, (int) bb.getY() + y);
          }
        }
      }
    }
  }

  @Override
  public void addToLaserJob(LaserJob job, GraphicSet objects)
  {
    for (LaserProperty prop : this.getLaserProperties())
    {
      Rectangle2D bb = objects.getBoundingBox();
      if (bb != null && bb.getWidth() > 0 && bb.getHeight() > 0)
      {
        BufferedImage scaledImg = new BufferedImage((int) bb.getWidth(), (int) bb.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = scaledImg.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, scaledImg.getWidth(), scaledImg.getHeight());
        if (objects.getTransform() != null)
        {
          Rectangle2D origBB = objects.getOriginalBoundingBox();
          Rectangle2D targetBB = new Rectangle(0, 0, scaledImg.getWidth(), scaledImg.getHeight());
          g.setTransform(Helper.getTransform(origBB, targetBB));
        }
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        for (GraphicObject o : objects)
        {
          o.render(g);
        }
        BufferedImageAdapter ad = new BufferedImageAdapter(scaledImg, invertColors);
        ad.setColorShift(this.getColorShift());
        job.getRaster3dPart().addImage(ad, prop, new Point((int) bb.getX(), (int) bb.getY()));
      }
    }
  }

  @Override
  public LaserProfile clone()
  {
    Raster3dProfile rp = new Raster3dProfile();
    rp.color = this.color;
    rp.colorShift = this.colorShift;
    rp.description = this.description;
    rp.invertColors = this.invertColors;
    rp.name = this.name;
    rp.thumbnailPath = this.thumbnailPath;
    //rp.laserProperties = new LinkedList<LaserProperty>();
    for (LaserProperty l : this.getLaserProperties())
    {
      rp.laserProperties.add(l.clone());
    }
    return rp;
  }
}
