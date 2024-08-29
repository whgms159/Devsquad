import { Route, Routes } from "react-router-dom";
import SideBar from "../components/mypage/SideBar";
import MypageMain from "../components/mypage/MypageMain";

const MyPage = () => {
  return (
    <>
      <SideBar />
      <Routes>
        <Route path="/" element={<MypageMain />} />
      </Routes>
    </>
  );
};

export default MyPage;
