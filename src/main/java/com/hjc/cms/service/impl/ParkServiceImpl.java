package com.hjc.cms.service.impl;

import com.hjc.cms.bean.Park;
import com.hjc.cms.bean.ParkConfig;
import com.hjc.cms.bean.YlConfig;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.dao.ParkConfigRepository;
import com.hjc.cms.dao.ParkRepository;
import com.hjc.cms.dao.YlConfigRepository;
import com.hjc.cms.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

    @Autowired
    YlConfigRepository ylConfigRepository;

    @Autowired
    ParkConfigRepository parkConfigRepository;

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

    @Override
    public void save(Park park) {

        YlConfig ylConfig = park.getYlConfig();
        if (ylConfig != null) {
            //设置银联支付参数
            // copy properties from #id=1
            YlConfig ylOne = ylConfigRepository.findById(1).orElse(null);
            ylConfig.setMsgSrc(ylOne.getMsgSrc()).setMsgSrcId(ylOne.getMsgSrcId())
                    .setYlKey(ylOne.getYlKey()).setMsgType(ylOne.getMsgType());

            park.setYlConfig(ylConfigRepository.save(ylConfig));
        }
        ParkConfig parkConfig = park.getParkConfig();
        if (parkConfig != null && park.getParkId().equals(parkConfig.getParkId())) {
            park.setParkConfig(parkConfigRepository.save(parkConfig));
        }
        parkRepository.save(park);

    }
}
