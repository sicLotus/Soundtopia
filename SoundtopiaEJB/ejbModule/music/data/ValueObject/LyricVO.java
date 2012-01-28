package music.data.ValueObject;

import music.data.DataObject.Lyric;

public class LyricVO {
	private String text;
	private String url;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public static LyricVO valueOf(Lyric lyric) {
		if (lyric != null) {
			LyricVO lyricVO = new LyricVO();
			lyricVO.setText(lyric.getText());
			lyricVO.setUrl(lyric.getUrl());
			return lyricVO;
		} else
			return null;
	}
}
