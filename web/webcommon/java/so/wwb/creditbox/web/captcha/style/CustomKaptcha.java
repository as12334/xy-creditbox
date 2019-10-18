package so.wwb.creditbox.web.captcha.style;

import com.google.code.kaptcha.BackgroundProducer;
import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.text.WordRenderer;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class CustomKaptcha extends DefaultKaptcha {
    private int width = 200;
    private int height = 50;

    public CustomKaptcha() {
    }

    public BufferedImage createImage(String text) {
        WordRenderer wordRenderer = this.getConfig().getWordRendererImpl();
        GimpyEngine gimpyEngine = this.getConfig().getObscurificatorImpl();
        BackgroundProducer backgroundProducer = this.getConfig().getBackgroundImpl();
        boolean isBorderDrawn = this.getConfig().isBorderDrawn();
        this.width = this.getConfig().getWidth();
        this.height = this.getConfig().getHeight();
        BufferedImage bi = wordRenderer.renderWord(text, this.width, this.height);
        bi = gimpyEngine.getDistortedImage(bi);
        bi = backgroundProducer.addBackground(bi);
        Graphics2D graphics = bi.createGraphics();
        if (isBorderDrawn) {
            this.drawBox(graphics);
        }

        return bi;
    }

    private void drawBox(Graphics2D graphics) {
        Color borderColor = this.getConfig().getBorderColor();
        int borderThickness = this.getConfig().getBorderThickness();
        graphics.setColor(borderColor);
        if (borderThickness != 1) {
            BasicStroke stroke = new BasicStroke((float)borderThickness);
            graphics.setStroke(stroke);
        }

        Line2D line1 = new Line2D.Double(0.0D, 0.0D, 0.0D, (double)this.width);
        graphics.draw(line1);
        Line2D line2 = new Line2D.Double(0.0D, 0.0D, (double)this.width, 0.0D);
        graphics.draw(line2);
        line2 = new Line2D.Double(0.0D, (double)(this.height - 1), (double)this.width, (double)(this.height - 1));
        graphics.draw(line2);
        line2 = new Line2D.Double((double)(this.width - 1), (double)(this.height - 1), (double)(this.width - 1), 0.0D);
        graphics.draw(line2);
    }
}
