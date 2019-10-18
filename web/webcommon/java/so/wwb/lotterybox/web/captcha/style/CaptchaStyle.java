package so.wwb.lotterybox.web.captcha.style;

import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.NoiseProducer;
import com.google.code.kaptcha.util.Configurable;
import com.jhlabs.image.RippleFilter;
import com.jhlabs.image.WaterFilter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CaptchaStyle extends Configurable implements GimpyEngine {
    public CaptchaStyle() {
    }

    @Override
    public BufferedImage getDistortedImage(BufferedImage baseImage) {
        NoiseProducer noiseProducer = this.getConfig().getNoiseImpl();
        BufferedImage distortedImage = new BufferedImage(baseImage.getWidth(), baseImage.getHeight(), 2);
        Graphics2D graphics = (Graphics2D)distortedImage.getGraphics();
        RippleFilter rippleFilter = new RippleFilter();
        rippleFilter.setWaveType(0);
        rippleFilter.setXAmplitude(0.6F);
        rippleFilter.setYAmplitude(0.7F);
        rippleFilter.setXWavelength(5.0F);
        rippleFilter.setYWavelength(2.0F);
        rippleFilter.setEdgeAction(0);
        WaterFilter waterFilter = new WaterFilter();
        waterFilter.setAmplitude(0.5F);
        waterFilter.setPhase(10.0F);
        waterFilter.setWavelength(2.0F);
        BufferedImage effectImage = waterFilter.filter(baseImage, null);
        effectImage = rippleFilter.filter(effectImage, null);
        graphics.drawImage(effectImage, 0, 0, null, null);
        graphics.dispose();
        noiseProducer.makeNoise(distortedImage, 0.1F, 0.1F, 0.25F, 0.25F);
        noiseProducer.makeNoise(distortedImage, 0.1F, 0.25F, 0.5F, 0.9F);
        return distortedImage;
    }
}
