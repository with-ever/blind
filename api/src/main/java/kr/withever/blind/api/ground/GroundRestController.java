package kr.withever.blind.api.ground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.withever.blind.ground.entity.Ground;
import kr.withever.blind.ground.entity.GroundType;

/**
 * @author jsg
 * @since 2019-09-13
 */
@Api(value = "/ground", description = "그라운드 api")
@RestController
@RequestMapping("/ground")
public class GroundRestController {

  @ApiOperation(value = "회원 로그인시 카테고리 리스트", notes = "카테고리 리스트", httpMethod = "GET",
      response = Map.class, produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"), @ApiResponse(code = 500, message = "저장중 오류 발생")})
  @ApiImplicitParams({
      @ApiImplicitParam(name = "memberNo", value = "회원번호", required = true,
          dataType = "string", paramType = "path"),
  })
  @GetMapping("/{memberNo}")
  public Map<String, Object> memberCategory(@PathVariable String memberNo) {
    Ground ground = new Ground(1, GroundType.COMPANY, "네이버");
    Ground ground2 = new Ground(1, GroundType.FREE, "자유");

    List<Ground> list = new ArrayList<Ground>();
    list.add(ground);
    list.add(ground2);
    Map<String, Object> rtnMap = new HashMap<String, Object>();
    rtnMap.put("memberNo", memberNo);
    rtnMap.put("Categorylist", list);
    return rtnMap;
  }


}
