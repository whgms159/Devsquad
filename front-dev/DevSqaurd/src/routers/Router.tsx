import { Route, Routes } from "react-router-dom";
import Layout from "../layouts/Layout";
import SideBar from "../components/mypage/SideBar";
import ProjectMain from "../components/project/ProjectMain";
import MainPage from "../pages/MainPage";
import CommunityPage from "../pages/CommunityPage";
import ProjectPage from "../pages/ProjectPage";
import MyPage from "../pages/MyPage";

export default function Router() {
  return (
    <Routes>
      <Route element={<Layout />}>
      
        {/* 메인 페이지 */}
        <Route path="/" element={<MainPage />} />

        {/* 프로젝트 페이지 */}
        <Route path="/project/*" element={<ProjectPage />}/>
        
        {/* 커뮤니티 페이지 */}
        <Route path="/community/*" element={<CommunityPage/>}/>

        {/* 마이 페이지 */}
        <Route path="/my-page/*" element={<MyPage />} />

      </Route>
    </Routes>
  );
}
