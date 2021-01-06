<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-19
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar">
    <a href="#" class="sidebar-toggler">
        <i data-feather="menu"></i>
    </a>
    <div class="navbar-content">
        <form class="search-form mb-0">
            <div class="input-group" style="font-weight: bold;font-size: 16px; color: #333333;">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                     stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                     class="feather feather-database link-icon">
                    <ellipse cx="12" cy="5" rx="9" ry="3"></ellipse>
                    <path d="M21 12c0 1.66-4 3-9 3s-9-1.34-9-3"></path>
                    <path d="M3 5v14c0 1.66 4 3 9 3s9-1.34 9-3V5"></path>
                </svg>
                <span class="ml-2" style="line-height: 1.7" id="navBarTitle">바꿔먹어 관리자 페이지</span>
            </div>
        </form>
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="languageDropdown" role="button"
                   data-toggle="dropdown"   aria-haspopup="true" aria-expanded="false">
                    <i class="flag-icon flag-icon-kr mt-1" title="us"></i> <span
                        class="font-weight-medium ml-1 mr-1">Korea</span>
                </a>
            </li>
            <li class="nav-item dropdown nav-apps">
                <a class="nav-link dropdown-toggle" href="#" id="appsDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                         stroke-linejoin="round" class="feather feather-grid">
                        <rect x="3" y="3" width="7" height="7"></rect>
                        <rect x="14" y="3" width="7" height="7"></rect>
                        <rect x="14" y="14" width="7" height="7"></rect>
                        <rect x="3" y="14" width="7" height="7"></rect>
                    </svg>
                </a>
                <div class="dropdown-menu" aria-labelledby="appsDropdown">
                    <div class="dropdown-header d-flex align-items-center justify-content-between">
                        <p class="mb-0 font-weight-medium">바로가기</p>
                    </div>
                    <div class="dropdown-body">
                        <div class="d-flex align-items-center apps">
                            <a href="/admin/admin_development">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                     viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                     stroke-linecap="round" stroke-linejoin="round"
                                     class="feather feather-box link-icon">
                                    <path d="M21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16z"></path>
                                    <polyline points="3.27 6.96 12 12.01 20.73 6.96"></polyline>
                                    <line x1="12" y1="22.08" x2="12" y2="12"></line>
                                </svg>
                                <p>개발</p></a>
                            <a href="/admin/admin_marketing">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                     viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                     stroke-linecap="round" stroke-linejoin="round"
                                     class="feather feather-users link-icon">
                                    <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                                    <circle cx="9" cy="7" r="4"></circle>
                                    <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                                    <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                                </svg>
                                <p>마케팅</p></a>
                        </div>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown nav-profile">
                <a class="nav-link dropdown-toggle" href="#" id="profileDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Admin
                </a>
                <div class="dropdown-menu" aria-labelledby="profileDropdown">
                    <div class="dropdown-header d-flex flex-column align-items-center"
                         style="border-bottom: none;">
                        <div class="figure mb-3" style="font-weight: bold">
                            나우<span style="color: #727cf5;">부동산</span>
                        </div>
                        <div class="info text-center">
                            <p class="name font-weight-bold mb-0">yang dong Kyun</p>
                            <p class="email text-muted mb-3">ehdrbdndns@naver.com</p>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</nav>
