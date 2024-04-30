package com.mm.area.model.service;

import java.util.ArrayList;

import com.mm.area.model.vo.Sido;
import com.mm.area.model.vo.Sigungu;

public interface AreaService {
	ArrayList<Sido> getSido();

	ArrayList<Sigungu> getSigungu(int sidoNo);
}
