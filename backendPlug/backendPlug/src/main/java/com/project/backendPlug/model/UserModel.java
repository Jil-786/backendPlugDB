package com.project.backendPlug.model;

import java.time.LocalDateTime;

public class UserModel {
	
	 	private String email;

	    private String passwordHash;

	    private Boolean isVerified;

	    private Integer tokensLeftToday;

	    private String role;

	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}

		public Boolean getIsVerified() {
			return isVerified;
		}

		public void setIsVerified(Boolean isVerified) {
			this.isVerified = isVerified;
		}

		public Integer getTokensLeftToday() {
			return tokensLeftToday;
		}

		public void setTokensLeftToday(Integer tokensLeftToday) {
			this.tokensLeftToday = tokensLeftToday;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}
	    
}
