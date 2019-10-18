package so.wwb.creditbox.web.captcha.style;

import com.google.code.kaptcha.BackgroundProducer;
import com.google.code.kaptcha.util.Configurable;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class CustomBackground extends Configurable implements BackgroundProducer {
    public CustomBackground() {
    }

    @Override
    public BufferedImage addBackground(BufferedImage baseImage) {
        Color colorFrom = randomColor();
        Color colorTo = randomColor();
        int width = baseImage.getWidth();
        int height = baseImage.getHeight();
        BufferedImage imageWithBackground = new BufferedImage(width, height, 1);
        Graphics2D graph = (Graphics2D)imageWithBackground.getGraphics();
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        hints.add(new RenderingHints(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        hints.add(new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        hints.add(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        graph.setRenderingHints(hints);
        GradientPaint paint = new GradientPaint(0.0F, 0.0F, colorFrom, (float)width, (float)height, colorTo);
        graph.setPaint(paint);
        graph.fill(new Rectangle2D.Double(0.0D, 0.0D, (double)width, (double)height));
        graph.drawImage(baseImage, 0, 0, null);
        return imageWithBackground;
    }

    private Color randomColor() {
        Color[] colors = {
                new Color(240,255,255),
                new Color(245,255,250),
                new Color(245,245,220),
                new Color(255,250,240),
                new Color(255,245,238),
                new Color(255,250,250),
                new Color(245,245,245),
                new Color(255,240,245),
                new Color(248,248,255),
                new Color(240,248,255),
                new Color(230,230,250),
                new Color(240,255,240),
                new Color(245,245,220),
                new Color(255,228,225),
                new Color(255,255,240),
                new Color(224,255,255),
                new Color(245,230,250)
        };

        int random = (int)(Math.random() * colors.length);
        return colors[random];
    }
}
