package com.learn.hib.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.learn.hib.config.AppConfig;
import com.learn.hib.dao.SingerDao;
import com.learn.hib.entities.Album;
import com.learn.hib.entities.Instrument;
import com.learn.hib.entities.Singer;

public class SpringHibDemo {
	private static Logger logger = LoggerFactory.getLogger(SpringHibDemo.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		listSingers(singerDao.findAll());
		Singer singer = singerDao.findById(2l);
		logger.info(singer.toString());
		listSingersWithAlbum(singerDao.findAllWithAlbum());
		ctx.close();
	}

	private static void listSingersWithAlbum(List<Singer> singers) {
		for (Singer singer : singers) {
			if (singer.getAlbums() != null) {
				for (Album album : singer.getAlbums()) {
					logger.info(album.toString());
				}
			}

			if (singer.getInstruments() != null) {
				for (Instrument instrument : singer.getInstruments()) {
					logger.info(instrument.toString());
				}
			}
		}
	}

	private static void listSingers(List<Singer> singers) {
		for (Singer singer : singers) {
			System.out.println(singer);
		}
	}
}
