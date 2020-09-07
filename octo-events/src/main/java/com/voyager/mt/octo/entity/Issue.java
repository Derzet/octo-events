package com.voyager.mt.octo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table
@Builder
public class Issue {

    @Id
    private Long id;

    @OneToMany(mappedBy = "issue")
    private List<Event> events;

}
