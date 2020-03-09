package com.hjc.cms.dao;

import com.hjc.cms.bean.Park;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * auto generated by gradle
 */
@Repository
public interface ParkRepository extends JpaRepository<Park, String> {
//    @Transactional
//    @Modifying
//    @Query("update Park a set a.lastUpdate=CURRENT_TIMESTAMP, a.parkName=:parkName, a.proxyState=:proxyState, a.proxyVersion=:proxyVersion, a.freeCount=:freeCount where a.parkId=:parkId")
//    void updateProxy(String parkName, Short proxyState, Integer freeCount, Integer proxyVersion, String parkId);
//
//    List<Park> findByParkIdIn(String[] parkIds);
//
//    List<Park> findByParkNameLike(String parkName);

   // @Query("select p from Park p where (p.parkName like :parkName or p.parkId like :parkId) and (p.parkId in :parkIds pr :parkIds is null")
    Page<Park> findByParkNameLikeOrParkIdLikeAndParkIdIn(String parkName, String parkId, String[] parkIds, Pageable pageable);
    //@Query("select p from Park p where (p.parkName like :parkName or p.parkId like :parkId) and p.parkId in :parkIds")
    Page<Park> findByParkNameLikeOrParkIdLike(String parkName, String parkId, Pageable pageable);

//    @Query(value = "select  new xd.fw.bean.ParkModel(p.parkId,p.parkName) FROM Park p WHERE p.parkId NOT IN (:parkIds)")
//    List<ParkModel>    findByParkModelIdNotIn(String[] parkIds);
//    @Query(value = "select  new xd.fw.bean.ParkModel(p.parkId,p.parkName) FROM Park p")
//    List<ParkModel>    findByParkModelAll();
//    @Query(value = "select  new xd.fw.bean.ParkModel(p.parkId,p.parkName) FROM Park p WHERE p.parkId  IN (:parkIds)")
//    List<ParkModel>    findByParkModelIdIn(String[] parkIds);
}