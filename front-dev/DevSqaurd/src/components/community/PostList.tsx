import React, { useState, useEffect } from 'react';
import style from './styles/PostList.module.css';

interface Post {
  id: number;
  title: string;
  author: string;
  date: string;
  hits: number;
}

// 개별 게시물 항목 컴포넌트
const PostItem: React.FC<Post> = ({ id, title, author, date, hits }) => (
  <tr className={style.postItem}>
    <th>{id}</th>
    <th>{title}</th>
    <th>{author}</th>
    <th>{date}</th>
    <th>{hits}</th>
  </tr>
);

export default function PostList() {
  const [posts, setPosts] = useState<Post[]>([]);

  useEffect(() => {
    // 데이터를 API에서 가져오는 부분

    // 예시로 하드코딩된 데이터
    const fetchPosts = async () => {
      // 예시 데이터
      const examplePosts: Post[] = [
        { id: 1, title: '첫 번째 게시물', author: '작성자1', date: '2024-09-01', hits: 47 },
        { id: 2, title: '두 번째 게시물', author: '작성자2', date: '2024-09-02', hits: 35 }
      ];
      setPosts(examplePosts);
    };

    fetchPosts();
  }, []);

  return (
    <div className={style.postListContainer}>
      <h4>게시판</h4>
      <table className={style.postTable}>
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          {
            posts.map((post, idx) => (
              <PostItem 
                id={idx+1} 
                title={post.title} 
                author={post.author} 
                date={post.date} 
                hits={post.hits}
              />
            ))
          }
        </tbody>
      </table>
    </div>
  );
}
