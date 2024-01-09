package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang= "javascript", script = "_this.price *_this.quantity >= 10000", message = "10000원 넘게 입력해주세요")
// 지금 ScripAssert의 javascript는 지원하지 않는다
public class Item {

//    @NotNull(groups = UpdateCheck.class) // 수정 요구사항 추가
    private Long id;

//    @NotBlank(message = "공백은 안돼", groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Max(value = 9999, groups = SaveCheck.class) // 수정 요구사항을 추가하자
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
