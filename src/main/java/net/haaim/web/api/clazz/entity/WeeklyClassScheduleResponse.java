package net.haaim.web.api.clazz.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class WeeklyClassScheduleResponse {

	
	private String lastDate;
	private String nextDate;
	private Map<Integer, List<WeeklyClassScheduleVO>> data;
	
	@Builder
	public WeeklyClassScheduleResponse(String preDate, String nextDate, List<WeeklyClassScheduleVO> list) {
		this.lastDate = preDate;
		this.nextDate = nextDate;
		this.data = transResponseData(list);
	}
	private Map<Integer, List<WeeklyClassScheduleVO>> transResponseData(List<WeeklyClassScheduleVO> list) {
		//list는 정렬이 되어 있다고 가정한다.
		
		String baseDate = null;
		Map<Integer, List<WeeklyClassScheduleVO>> data = new TreeMap();
		int index = 1;
		for(WeeklyClassScheduleVO e : list) {
			if(baseDate == null ) {
				baseDate = e.getBaseDate();
			} else {
				if(!baseDate.equals(e.getBaseDate())) {
					baseDate = e.getBaseDate();
					index++;
				}
				set(data, index, e);
			}
		}
		return data;
	}
	private void set(Map<Integer, List<WeeklyClassScheduleVO>> data, Integer index, WeeklyClassScheduleVO e) {
		List<WeeklyClassScheduleVO> entityList = null;
		if(!data.containsKey(index)) {
			data.put(index, new ArrayList());
		} 
		entityList = data.get(index);
		entityList.add(e);
	}
}
