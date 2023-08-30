package dat3.car.api;

import dat3.car.DTO.MemberRequest;
import dat3.car.DTO.MemberResponse;
import dat3.car.Service.MemberService;
import dat3.car.entity.Member;
import dat3.car.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
class MemberController {

  MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



    //Security: Admin only
    //Ved at få den til at returnere MemberResponse kan den automamtisk lave vores DTO'er til JSON
    //Hvis vi skrev Members ville vi få alt data i member tabellen, og det vil vi ikke have.
    @GetMapping
    List<MemberResponse> getMembers() {
        return memberService.getMembers(false);
    }

    //Security = admin
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) throws Exception {
      return memberService.findById(username);

    }

    //Security --> Anonymous
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MemberResponse addMember(@RequestBody MemberRequest body) {
        return memberService.addMember(body);
    }

    //Security = admin (hvis bruger skal kunne gøre det skal det køres på en anden måde
    @PutMapping("/{username}")
   void editMember(@RequestBody MemberRequest body, @PathVariable String username) {
      memberService.editMember(body,username);

    }

  //Security ADMIN
  @PatchMapping("/ranking/{username}/{value}")
  void setRankingForUser(@PathVariable String username, @PathVariable int value) {
    memberService.setRankingForUser(username,value);
  }

  // Security ADMIN
  @DeleteMapping("/{username}")
  void deleteMemberByUsername(@PathVariable String username) {
    memberService.deleteMemberByUsername(username);
  }

}
