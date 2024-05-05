package com.gauravtech.googleformApi.FormDto;

import com.google.api.services.forms.v1.model.Info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFormDto {
private Info title;

public Info getTitle() {
	return title;
}
public void setTitle(Info title) {
	this.title = title;
}
}





