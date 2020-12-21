package com.choijh.route;

import com.choijh.datamodel.dto.SaleDTO;
import com.choijh.datamodel.dto.UserDTO;
import com.choijh.datamodel.enumModel.UserGradeEnum;
import com.choijh.datamodel.UserTotalPaidPrice;
import com.choijh.model.User;
import com.choijh.service.SaleService;
import com.choijh.service.UserService;
import com.choijh.datamodel.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRoute {
    private final UserService userService;
    private final SaleService saleService;

    @Autowired
    public UserRoute(UserService userService, SaleService saleService) {
        this.userService = userService;
        this.saleService = saleService;
    }

    @GetMapping
    @ResponseBody
    public List<UserDTO> getUsers() {
        return this.userService.users();
    }

    @GetMapping("/{user_id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable(value="user_id") String userId) throws Exception{
        return this.userService.userById(Integer.parseInt(userId));
    }

    @PostMapping
    public int createUser(UserRegisterVO user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/initialize")
    public void initializeUsers() {
        this.userService.initializeUsers();
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable(value="user_id") String userId) {
        this.userService.deleteUser(Integer.parseInt(userId));
    }

    @GetMapping("/{user_id}/purchase_list")
    public List<SaleDTO> getUserPurchaseList(@PathVariable(value="user_id") String userId) {
        return this.saleService.getSalesByUserId(Integer.parseInt(userId));
    }

    @GetMapping("/{user_id}/purchase_amount")
    public UserTotalPaidPrice getUserPurchaseAmount(@PathVariable(value="user_id") String userId) {
        return this.saleService.getTotalPaidPriceByUserId(Integer.parseInt(userId));
    }

    @GetMapping("/{user_id}/grade")
    @ResponseBody
    public UserGradeEnum getUserGrade(@PathVariable(value="user_id") String userId) {
        return this.userService.getUserGrade(Integer.parseInt(userId));
    }
}
