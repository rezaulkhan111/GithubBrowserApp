package com.machinecode.github_project.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
data class LoginResponse(
    @SerializedName("current_user_url")
    @Expose
    private var currentUserUrl: String,
    @SerializedName("current_user_authorizations_html_url")
    @Expose
    private var currentUserAuthorizationsHtmlUrl: String,
    @SerializedName("authorizations_url")
    @Expose
    private var authorizationsUrl: String,
    @SerializedName("code_search_url")
    @Expose
    private var codeSearchUrl: String,
    @SerializedName("commit_search_url")
    @Expose
    private var commitSearchUrl: String,
    @SerializedName("emails_url")
    @Expose
    private var emailsUrl: String,
    @SerializedName("emojis_url")
    @Expose
    private var emojisUrl: String,
    @SerializedName("events_url")
    @Expose
    private var eventsUrl: String,
    @SerializedName("feeds_url")
    @Expose
    private var feedsUrl: String,
    @SerializedName("followers_url")
    @Expose
    private var followersUrl: String,
    @SerializedName("following_url")
    @Expose
    private var followingUrl: String,
    @SerializedName("gists_url")
    @Expose
    private var gistsUrl: String,
    @SerializedName("hub_url")
    @Expose
    private var hubUrl: String,
    @SerializedName("issue_search_url")
    @Expose
    private var issueSearchUrl: String,
    @SerializedName("issues_url")
    @Expose
    private var issuesUrl: String,
    @SerializedName("keys_url")
    @Expose
    private var keysUrl: String,
    @SerializedName("label_search_url")
    @Expose
    private var labelSearchUrl: String,
    @SerializedName("notifications_url")
    @Expose
    private var notificationsUrl: String,
    @SerializedName("organization_url")
    @Expose
    private var organizationUrl: String,
    @SerializedName("organization_repositories_url")
    @Expose
    private var organizationRepositoriesUrl: String,
    @SerializedName("organization_teams_url")
    @Expose
    private var organizationTeamsUrl: String,
    @SerializedName("public_gists_url")
    @Expose
    private var publicGistsUrl: String,
    @SerializedName("rate_limit_url")
    @Expose
    private var rateLimitUrl: String,
    @SerializedName("repository_url")
    @Expose
    private var repositoryUrl: String,
    @SerializedName("repository_search_url")
    @Expose
    private var repositorySearchUrl: String,
    @SerializedName("current_user_repositories_url")
    @Expose
    private var currentUserRepositoriesUrl: String,
    @SerializedName("starred_url")
    @Expose
    private var starredUrl: String,
    @SerializedName("starred_gists_url")
    @Expose
    private var starredGistsUrl: String,
    @SerializedName("topic_search_url")
    @Expose
    private var topicSearchUrl: String,
    @SerializedName("user_url")
    @Expose
    private var userUrl: String,
    @SerializedName("user_organizations_url")
    @Expose
    private var userOrganizationsUrl: String,
    @SerializedName("user_repositories_url")
    @Expose
    private var userRepositoriesUrl: String,
    @SerializedName("user_search_url")
    @Expose
    private var userSearchUrl: String
)