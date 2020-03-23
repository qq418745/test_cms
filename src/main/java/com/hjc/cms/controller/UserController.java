package com.hjc.cms.controller;




import com.hjc.cms.bean.User;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.entity.Result;
import com.hjc.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("user")
public class UserController extends BaseController {

 @Autowired
    UserService userService;
//
//    @Value("${version}")
//    String version;
//
//    @Value("${web-name}")
//    String webName;
//
//
//
//    @RequestMapping("sessionUser")
//    @ResponseBody
//    public ModelRequest sessionUser() {
//        return userLogin();
//
//    }

    @RequestMapping("currentUser")
    public Result userLogin() {
        return new Result(true,"请求成功").setInfo(currentUser());

    }
//
//    @RequestMapping("userLogout")
//    public String userLogout() {
//        //session.removeAttribute(USER_KEY);
//        return DONE;
//    }
//
//    @RequestMapping("changePassword")
//    @ResponseBody
//    public String changePassword(User user, String newPassword) throws Exception {
//        User dbUser = userRepository.findByName(user.getName());
//        //check user password first
//        if (!dbUser.getPassword().equals(FwUtil.md5(user.getPassword()))) {
//            throw new FwException("original user name is error!");
//        }
//        dbUser.setPassword(FwUtil.md5(newPassword));
//        userRepository.save(dbUser);
//        return DONE;
//    }
//    @RequestMapping("resetPassword")
//    @ResponseBody
//    public String resetPassword(Integer userId, String adminPassword, String newPassword) {
//        User adminUser = currentUser();
//        if (!FwUtil.md5(adminPassword).equals(adminUser.getPassword())) {
//            throw new FwException("admin user is not correct");
//        }
//        runSessionCommit(() -> {
//            User dbUser = userRepository.getOne(userId);
//            dbUser.setPassword(FwUtil.md5(newPassword));
//            userRepository.save(dbUser);
//        });
//        return DONE;
//    }

    @RequestMapping("findPage")
    public PageResult obtainUsers(int page, int rows, User user) {

        PageResult byPage = userService.findByPage(user, page, rows);
        return byPage;
    }

//    @RequestMapping("deleteUser")
//    @ResponseBody
//    public String deleteUser(int[] userIds) {
//        for (int id : userIds) {
//            userRepository.delete(id);
//        }
//        return DONE;
//    }
//
//    @RequestMapping("saveUser")
//    @ResponseBody
//    public String saveUser(User user) throws Exception {
//        userRepositoryCustom.saveUser(user);
//        return DONE;
//    }

//    @RequestMapping("version")
//    @ResponseBody
//    public String version() {
//        return String.format("{\"name\":\"%s\",\"version\":\"%s\"}", webName, version);
//    }
//
//
//
//    @RequestMapping("obtainUserParks")
//    @ResponseBody
//    public PageContent obtainUserParks(Integer userId) {
//        return page(parkRepository.findByParkModelIdIn(remakeToPakrId(userId)));
//    }
//
//    @RequestMapping("obtainUserNoParks")
//    @ResponseBody
//    public PageContent obtainUserNoParks(Integer userId) {
//        return page(remakeToPakrId(userId) == null ?    parkRepository.findByParkModelAll() :parkRepository.findByParkModelIdNotIn(remakeToPakrId(userId)) );
//    }
//
//    @RequestMapping("deleteUserParks")
//    @ResponseBody
//    public String deleteUserParks(String[] delParkIds, Integer userId) {
//        User user = userRepository.findOne(userId);
//        ArrayList<String> parkIds = new ArrayList<String>(Arrays.asList(remakeToPakrId(userId)));
//        for (String delParkId : delParkIds) {
//            parkIds.remove(delParkId);
//        }
//        //一个都没
//        if (parkIds.isEmpty())
//            user.setRemark(null);
//        else
//            user.setRemark(remarkFormat(parkIds));
//        userRepository.save(user);
//        return DONE;
//    }
//
//    @RequestMapping("saveUserParks")
//    @ResponseBody
//    public String saveUserParks(String[] parkIds, Integer userId) {
//        if (parkIds != null && parkIds.length > 0) {
//            User user = userRepository.findOne(userId);
//            if (StringUtils.isEmpty(user.getRemark())){
//                user.setRemark(remarkFormat(new ArrayList(Arrays.asList(parkIds))));
//            }
//            else{
//                String remark1 =   user.getRemark().charAt(user.getRemark().length()-1) == ';' ?  user.getRemark() : user.getRemark()+";";
//                user.setRemark(remark1+remarkFormat(new ArrayList(Arrays.asList(parkIds))));
//            }
//            userRepository.save(user);
//        }
//        return DONE;
//    }
//    //List不为空时
//    private String remarkFormat(List remakeList) {
//        String string = remakeList.toString();
//        return string.replace(",", ";").substring(1, string.length() - 1).replace(" ", "");
//    }
//    String[] remakeToPakrId(Integer userId) {
//        String remark = userRepository.findOne(userId).getRemark();
//        return StringUtils.isEmpty(remark) ? null : userRepository.findOne(userId).getRemark().split(";");
//    }
//
//    @RequestMapping("verify")
//    @ResponseBody
//    public String verify(Integer userId) {
//        System.out.println(userId);
//        User user = userRepository.findOne(userId);
//        List<Role> roles = user.getRoles();
//        Boolean flag = false;
//        for (Role role : roles) {
//            if( role.getId()==1){
//                flag =true;
//                break;
//            }
//        }
//        return   flag ?  DONE : FAIL;
//    }
}
