package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator

class CompanyImpl(companyValidator: CompanyValidator) {

  def createCompany(company: Company): Option[String] = {
    if (companyValidator.companyIsValid(company)) {
        println("=>Company ='"+company.name+"' is created successfully!")
        Option(company.name)
    }

    else {
      println("=>Company ='"+company.name+"' is not created due to above reason!")
      None
    }
  }
}
