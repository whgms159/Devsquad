import { Route, Routes } from "react-router-dom";
import SideBar from "../components/mypage/SideBar";

const MyPage = () => {
    return (
      <Routes>
        <Route path="/" element={<SideBar />} />
    </Routes>
    );
};

export default MyPage;