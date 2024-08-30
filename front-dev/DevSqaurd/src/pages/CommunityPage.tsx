import { Route, Routes } from "react-router-dom";
import AllPosts from "../components/community/AllPosts";

const CommunityPage = () => {
    return (
        <>
          <div>CommunityPage</div>
          <Routes>
            <Route path="/" element={<AllPosts/>} />
          </Routes>
        </>
    );
};

export default CommunityPage;