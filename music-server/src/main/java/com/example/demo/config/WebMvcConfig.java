package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
    /*
     *这是歌曲图片
     */
    @Value("${picConfig.path.song.win}")
    private String songWinPath;
    @Value("${picConfig.path.song.other}")
    private String songOtherPath;

    @Value("${picConfig.path.songPic.win}")
    private String songPicWinPath;
    @Value("${picConfig.path.songPic.other}")
    private String songPicOtherPath;
    /*
     *这是歌单图片
     */
    @Value("${picConfig.path.songListPic.win}")
    private String songListPicWinPath;
    @Value("${picConfig.path.songListPic.other}")
    private String songListPicOtherPath;
    /*
     *这是歌手图片
     */
    @Value("${picConfig.path.singerPic.win}")
    private String singerPicWinPath;
    @Value("${picConfig.path.singerPic.other}")
    private String singerPicOtherPath;
    /*
     *这是用户头像
     */
    @Value("${picConfig.path.avatorImages.win}")
    private String avatorImagesWinPath;
    @Value("${picConfig.path.avatorImages.other}")
    private String avatorImagesOtherPath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            /*
             *这是歌曲图片
             */
            registry.addResourceHandler("/img/songPic/**", "/music/song/**")
                    .addResourceLocations(songWinPath, songPicWinPath);
            logger.info("歌曲:"+songWinPath);
            logger.info("歌曲图片:"+songPicWinPath);
            /*
             *这是歌单图片
             */
            registry.addResourceHandler("/img/songListPic/**")
                    .addResourceLocations(songListPicWinPath);
            logger.info("歌单图片:"+songListPicWinPath);
            /*
             *这是歌手图片
             */
            registry.addResourceHandler("/img/singerPic/**")
                    .addResourceLocations(singerPicWinPath);
            logger.info("歌手图片:"+singerPicWinPath);
            /*
             *这是用户图片
             */
            registry.addResourceHandler("/img/avatorImages/**")
                    .addResourceLocations(avatorImagesWinPath);
            logger.info("用户图片:"+avatorImagesWinPath);

        } else {  //linux 和mac
            /*
             *这是歌曲图片
             */
            registry.addResourceHandler("/img/songPic/**", "/music/song/**")
                    .addResourceLocations(songOtherPath, songPicOtherPath);
            logger.info("歌曲:"+songOtherPath);
            logger.info("歌曲图片:"+songPicOtherPath);
            /*
             *这是歌单图片
             */
            registry.addResourceHandler("/img/songListPic/**")
                    .addResourceLocations(songListPicOtherPath);
            logger.info("歌单图片:"+songListPicOtherPath);
            /*
             *这是歌手图片
             */
            registry.addResourceHandler("/img/singerPic/**")
                    .addResourceLocations(singerPicOtherPath);
            logger.info("歌手图片:"+singerPicOtherPath);
            /*
             *这是用户图片
             */
            registry.addResourceHandler("/img/avatorImages/**")
                    .addResourceLocations(avatorImagesOtherPath);
            logger.info("用户图片:"+avatorImagesOtherPath);
        }
    }
}
