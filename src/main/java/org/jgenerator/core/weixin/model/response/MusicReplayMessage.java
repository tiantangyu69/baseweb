package org.jgenerator.core.weixin.model.response;

/**
 * 音乐消息
 * 
 * @author LIZHITAO
 */
public class MusicReplayMessage extends BaseReplayMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

}