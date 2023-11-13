package com.api.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "test")
@Setter
@Getter
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class Test {
   
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="mb_id")
    private String mbId;

    @Column(name="mb_pw")
    private String mbPw;

    @Column(name="address")
    private String address;

    @Column(name="mb_tell")
    private String mbTell;

    @Override
    public String toString() {
        return "Test [id=" + id + ", mbId=" + mbId + ", mbPw=" + mbPw + ", address=" + address + ", mbTell=" + mbTell
                + "]";
    }

    @OneToMany(mappedBy = "test")
    @JsonIgnore
    private List<TestAddressDetail> addressDetails;
}
