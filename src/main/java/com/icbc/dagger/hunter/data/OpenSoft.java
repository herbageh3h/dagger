package com.icbc.dagger.hunter.data;

import com.icbc.dagger.util.ShaUtil;

public class OpenSoft {
	private String name;
	private String version;
	private String category;
	private String app;
	private String path;
	private long size;
	private static final char SEP = ',';

	public String signature() {
		return ShaUtil.hashString(category + name + version);
	}

	public boolean sameSoft(OpenSoft soft) {
		return signature().equals(soft.signature());
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof OpenSoft)) {
			return false;
		}

		OpenSoft other = (OpenSoft) o;
		return (signature().equals(other.signature()));
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int ret = 1;

		String s = signature();
		ret = prime * ret + ("".equals(s) ? 0 : s.hashCode());
		return ret;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(app);
		sb.append(SEP);
		sb.append(category);
		sb.append(SEP);
		sb.append(name);
		sb.append(SEP);
		sb.append(version);
		sb.append(SEP);
		sb.append(path);
		sb.append(SEP);
		sb.append(size);

		return sb.toString();
	}

	public String csv() {
		StringBuilder sb = new StringBuilder();
		sb.append(app);
		sb.append(SEP);
		sb.append(category);
		sb.append(SEP);
		sb.append(name);
		sb.append(SEP);
		sb.append("=\"" + version + "\"");
		sb.append(SEP);
		sb.append(path);

		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
