package com.hjc.cms.controller;



import com.hjc.cms.bean.Park;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-01-20 10:35
 **/
@RestController
@RequestMapping("park")
public class ParkController extends BaseController{

	@Autowired
	ParkService parkService;
//
//	@Reference
//	private ParkService parkService;
//
//	/**
//	 * 返回全部列表
//	 * @return
//	 */
//	@RequestMapping("/findAll")
//	public List<TbPark> findAll(){
//		return parkService.findAll();
//	}
//
//
//	/**
//	 * 返回全部列表
//	 * @return
//	 */
//	@RequestMapping("/findPage")
//	public PageResult  findPage(int page,int rows){
//		return parkService.findPage(page, rows);
//	}
//
//	/**
//	 * 增加
//	 * @param park
//	 * @return
//	 */
//	@RequestMapping("/add")
//	public Result add(@RequestBody TbPark park){
//		try {
//			parkService.add(park);
//			return new Result(true, "增加成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result(false, "增加失败");
//		}
//	}
//
//	/**
//	 * 修改
//	 * @param park
//	 * @return
//	 */
//	@RequestMapping("/update")
//	public Result update(@RequestBody TbPark park){
//		try {
//			parkService.update(park);
//			return new Result(true, "修改成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result(false, "修改失败");
//		}
//	}
//
//	/**
//	 * 获取实体
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping("/findOne")
//	public TbPark findOne(Long id){
//		return parkService.findOne(id);
//	}
//
//	/**
//	 * 删除
//	 */
//	@RequestMapping("/delete")
//	public Result delete(Long [] ids){
//		try {
//			parkService.delete(ids);
//			return new Result(true, "删除成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result(false, "删除失败");
//		}
//	}
//
	/**
	 * 查询+分页
	 */
	@RequestMapping("search")
	public PageResult search(@RequestBody Park park, int page, int rows  ){

		return parkService.findPage(park, page, rows,currentUserParkIds());
	}
	
}
