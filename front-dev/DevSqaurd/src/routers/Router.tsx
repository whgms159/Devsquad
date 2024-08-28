import { Route, Routes } from "react-router-dom";
import Layout from "../layouts/Layout";
import TestPage from "../pages/TestPage";
import SideBar from "../components/mypage/SideBar";
import ProjectMain from "../components/project/ProjectMain";

export default function Router() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/test" element={<TestPage />} />
        <Route path="/mypage" element={<SideBar />} />
 
        <Route path="/project" element={<ProjectMain/>}/>
      </Route>
    </Routes>
  );
}
