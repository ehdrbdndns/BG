<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-17
  Time: 오후 5:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="sidebar">
    <div class="sidebar-header">
        <a href="/" class="sidebar-brand">
            B<span>G</span>
        </a>
        <div class="sidebar-toggler not-active ml-3">
            <span></span>
            <span></span>
            <span></span>
        </div>
    </div>
    <div class="sidebar-body">
        <ul class="nav">
            <li class="nav-item nav-category">HOME</li>
            <li class="nav-item">
                <a href="/homePage.do" class="nav-link">
                    <i class="link-icon" data-feather="box"></i>
                    <span class="link-title">HOME</span>
                </a>
            </li>
            <li class="nav-item nav-category">manage</li>
            <li class="nav-item">
                <a href="/analyticsPage.do" class="nav-link">
                    <i class="link-icon" data-feather="database"></i>
                    <span class="link-title">통계관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="/memberPage.do" class="nav-link">
                    <i class="link-icon" data-feather="user"></i>
                    <span class="link-title">회원관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="/advertisePage.do" class="nav-link">
                    <i class="link-icon" data-feather="cast"></i>
                    <span class="link-title">광고관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="/inquiryPage.do" class="nav-link">
                    <i class="link-icon" data-feather="phone"></i>
                    <span class="link-title">문의관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="/communityPage.do" class="nav-link">
                    <i class="link-icon" data-feather="users"></i>
                    <span class="link-title">커뮤니티 관리</span>
                </a>
            </li>
            <li class="nav-item nav-category">CUSTOMER SERVICE</li>
            <li class="nav-item">
                <a class="nav-link"  data-toggle="collapse" href="#charts" role="button" aria-expanded="false" aria-controls="charts">
                    <i class="link-icon" data-feather="user-plus"></i>
                    <span class="link-title">고객센터</span>
                    <i class="link-arrow" data-feather="chevron-down"></i>
                </a>
                <div class="collapse" id="charts">
                    <ul class="nav sub-menu">
                        <li class="nav-item">
                            <a href="/noticePage.do" class="nav-link">공지사항</a>
                        </li>
                        <li class="nav-item">
                            <a href="/faqPage.do" class="nav-link">FAQ</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="nav-item">
                <a href="/pushPage.do" class="nav-link">
                    <i class="link-icon" data-feather="mail"></i>
                    <span class="link-title">푸쉬 보내기</span>
                </a>
            </li>
            <li class="nav-item nav-category">LOGOUT</li>
            <li class="nav-item">
                <a href="/adminLogout.do" class="nav-link">
                    <i class="link-icon" data-feather="log-out"></i>
                    <span class="link-title">로그아웃</span>
                </a>
            </li>
        </ul>
    </div>
</nav>
<nav class="settings-sidebar">
    <div class="sidebar-body">
        <a href="#" class="settings-sidebar-toggler">
            <i data-feather="settings"></i>
        </a>
        <h6 class="text-muted">Sidebar:</h6>
        <div class="form-group border-bottom">
            <div class="form-check form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="sidebarThemeSettings" id="sidebarLight" value="sidebar-light">
                    Light
                </label>
            </div>
            <div class="form-check form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="sidebarThemeSettings" id="sidebarDark" value="sidebar-dark" checked>
                    Dark
                </label>
            </div>
        </div>
    </div>
</nav>