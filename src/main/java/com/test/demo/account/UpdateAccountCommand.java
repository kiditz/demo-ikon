package com.test.demo.account;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class UpdateAccountCommand {
    private Long id;
    private String name;
}
