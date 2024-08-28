import { Route, Routes } from "react-router-dom";
import "./App.css";
import TestPage from "./pages/TestPage";
import SideBar from "./components/mypage/SideBar";

function App() {
  return (
    <Routes>
      <Route path="/test" element={<TestPage />} />

      {/* 마이페이지 */}
      <Route path="/mypage" element={<SideBar />} />
    </Routes>
  );
}

export default App;
