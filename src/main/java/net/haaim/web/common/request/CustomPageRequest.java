package net.haaim.web.common.request;

import org.springframework.data.domain.Sort;

public final class CustomPageRequest {
	
    private static int getPage(int page) {
        return page <= 0 ? 1 : page;
    }

    private static int getSize(int size) {
        int DEFAULT_SIZE = 10;
        int MAX_SIZE = 50;
        return size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

   
    // getter

    public static org.springframework.data.domain.PageRequest of(int page, int size, String fieldName) {
    	Sort.Direction direction = Sort.Direction.DESC;
    	int aSize = getSize(size);
    	int aPage = getPage(page);
        return org.springframework.data.domain.PageRequest.of(aPage -1, aSize, direction, fieldName);
    }
}
