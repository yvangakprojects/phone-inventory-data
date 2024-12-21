package rw.phonix.inventory.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Data {
    private Integer year;
    private Double price;
    private String cpuModel;
    private String hardDiskSize;
}
