package org.sagacity.taglib.function;

public class PageNumber {

	private int minValue;

	private int maxValue;

	public static Integer getMinValue(Integer currentPage, Integer totalPage,
			Integer pageNumber) {

		if (totalPage == 0)

			totalPage = 1;

		PageNumber pageNumberParse = new PageNumber();

		pageNumberParse.getPage(currentPage, totalPage, pageNumber);

		return pageNumberParse.minValue;

	}

	public static Integer getMaxValue(Integer currentPage, Integer totalPage,
			Integer pageNumber) {

		if (totalPage == 0)

			totalPage = 1;

		PageNumber pageNumberParse = new PageNumber();

		pageNumberParse.getPage(currentPage, totalPage, pageNumber);

		return pageNumberParse.maxValue;

	}

	public void getPage(int currentPage, int totalPage, int pageNumber) {

		if (pageNumber >= totalPage) {

			setMinValue(1);

			setMaxValue(totalPage);

		} else {

			getPre(currentPage, totalPage, pageNumber);

			getNext(currentPage, totalPage, pageNumber);

			if (getMaxValue() == totalPage) {

				setMinValue(totalPage - (pageNumber - 1));

			}

			if (getMinValue() == 1) {

				setMaxValue(getMinValue() + (pageNumber - 1));

			}

		}

	}

	public void getPre(int currentPage, int totalPage, int pageNumber) {

		if (currentPage - (pageNumber - 1) / 2 > 0) {

			setMinValue(currentPage - (pageNumber - 1) / 2);

		} else {

			setMinValue(1);

		}

	}

	public void getNext(int currentPage, int totalPage, int pageNumber) {

		if (currentPage + (pageNumber - 1) / 2 > totalPage) {

			setMaxValue(totalPage);

		} else {

			setMaxValue(currentPage + (pageNumber - 1) / 2);

		}

	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

}
