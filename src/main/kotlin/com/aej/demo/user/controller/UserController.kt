package com.aej.demo.user.controller

import com.aej.demo.BaseResponse
import com.aej.demo.user.entity.User
import com.aej.demo.user.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/{name}")
    fun getUser(
        @PathVariable(value = "name") userName: String
    ): BaseResponse<User> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.getUserByName(userName)
        )
    }

    @GetMapping
    fun getUsers(): BaseResponse<List<User>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.getUsers()
        )
    }

    @PostMapping
    fun addUser(
        @RequestBody user: User
    ): BaseResponse<List<User>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.addUser(user)
        )
    }

    @GetMapping("/ids")
    fun getUser(): BaseResponse<List<String>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.getIds()
        )
    }
}