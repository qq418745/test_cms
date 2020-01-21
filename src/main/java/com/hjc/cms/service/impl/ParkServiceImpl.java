package com.hjc.cms.service.impl;

import com.hjc.cms.bean.Park;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.dao.ParkRepository;
import com.hjc.cms.service.ParkService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-01-20 09:36
 **/
@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    ParkRepository parkRepository;

//    /**
//     * 查询全部
//     */
//    @Override
//    public List<Park> findAll() {
//
//        String parkName = Optional.ofNullable(query.getParkName()).orElse("");
//        parkName = "%" + parkName + "%";
//
//        User user = currentUser();
//        Page<Park> list;
//
//        if (user == null || isAdmin(user) || isEmpty(user.getRemark())) {
//            list = parkRepository.findByParkNameLikeOrParkIdLike(parkName
//                    , parkName, pageRequest(page, limit));
//        } else {
//            String[] parkIds = user.getRemark().split(";");
//            list = parkRepository.findByParkNameLikeOrParkIdLikeAndParkIdIn(parkName
//                    , parkName, parkIds, pageRequest(page, limit));
//        }
//        return parkRepository.selectByExample(null);
//    }

    @Override
    public PageResult findPage(Park park, int page, int rows, String[] parkIds) {

        String parkName = Optional.ofNullable(park.getParkName()).orElse("");

            parkName = "%" + parkName + "%";

        Page<Park> list;

        if (parkIds != null && parkIds.length > 0) {

            list = parkRepository.findByParkNameLikeOrParkIdLikeAndParkIdIn(parkName
                    , parkName, parkIds,  PageRequest.of(page-1, rows));

        } else {
            list = parkRepository.findByParkNameLikeOrParkIdLike(parkName
                    , parkName, PageRequest.of(page-1, rows));
        }


        return new PageResult(list.getTotalElements(),list.getContent());
    }
}
